import socket
import time

# 1. Start the Time Daemon Server
daemon = socket.socket()
daemon.bind(('', 8080))
daemon.listen(1)

print("Time Daemon is running. Waiting for a client to connect...")

# 2. Accept connection from the Client machine
client_conn, address = daemon.accept()
print(f"Client connected from {address}!")

# 3. Get the Client's current time
client_time = float(client_conn.recv(1024).decode())
daemon_time = time.time() 

# 4. Berkeley Algorithm Core Logic
# Find the average between the Daemon and the Client
average_time = (daemon_time + client_time) / 2

# Calculate how much the Client needs to adjust its clock
client_adjustment = average_time - client_time

# 5. Send the adjustment back to the Client
client_conn.send(str(client_adjustment).encode())

# 6. Adjust the Daemon's own clock
daemon_time = daemon_time + (average_time - daemon_time)

print("\n--- Synchronization Complete ---")
print("Synchronized Daemon Time: ", time.ctime(daemon_time))