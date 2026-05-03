import socket
import time

# 1. Connect to the Time Daemon
client = socket.socket()
client.connect(('localhost', 8080)) # <-- CHANGE IP HERE for Machine A

# 2. Get this Client's current time 
# (We add 300 seconds so its clock is artificially 5 minutes ahead of the Daemon)
my_time = time.time() + 300  
print("Original Client Time: ", time.ctime(my_time))

# 3. Send our time to the Daemon
client.send(str(my_time).encode())

# 4. Wait for the Daemon to calculate and send back the adjustment amount
adjustment = float(client.recv(1024).decode())
print(f"Daemon says to adjust clock by: {adjustment} seconds")

# 5. Apply the adjustment to sync our clock
my_time = my_time + adjustment

print("\n--- Synchronization Complete ---")
print("Synchronized Client Time: ", time.ctime(my_time))