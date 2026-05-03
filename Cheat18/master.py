import socket
import time

# 1. Start the Master Server
master = socket.socket()
master.bind(('localhost', 8080))
master.listen(1)

print("Master is running. Waiting for a slave to connect...")

# 2. Accept the connection from the Slave
slave_connection, address = master.accept()
print("Slave connected!")

# 3. Get the Slave's current time
slave_time = float(slave_connection.recv(1024).decode())
master_time = time.time() # Get Master's current time

# 4. Berkeley Algorithm Math (Find the average)
# Add both times together and divide by 2
average_time = (master_time + slave_time) / 2

# Calculate how much the Slave needs to adjust its clock
slave_adjustment = average_time - slave_time

# 5. Send the adjustment back to the Slave
slave_connection.send(str(slave_adjustment).encode())

# 6. Adjust Master's own clock
master_time = master_time + (average_time - master_time)

print("Synchronization complete!")
print("Adjusted Master Time: ", time.ctime(master_time))