import socket
import time

# 1. Connect to the Master Server
slave = socket.socket()
slave.connect(('localhost', 8080)) # Change IP here if on 2 machines

# 2. Get the Slave's current time (+5 mins ahead)
my_time = time.time() + 300  

# FIXED: Wrapped in time.ctime() to make it readable
print("Original Slave Time: ", time.ctime(my_time))

# 3. Send our time to the Master
slave.send(str(my_time).encode())

# 4. Wait for the Master to send back the adjustment amount
adjustment = float(slave.recv(1024).decode())
print("Master says to adjust clock by: ", adjustment, " seconds")

# 5. Apply the adjustment to sync our clock with the Master
my_time = my_time + adjustment

print("Synchronization complete!")

# FIXED: Wrapped in time.ctime() to make it readable
print("Adjusted Slave Time: ", time.ctime(my_time))