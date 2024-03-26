import json
import random

# Generates a JSON of fake users

TECH_LIST = ["Java", "C#", "Python", "JavaScript", "Rust", "Git", "SQL"]
USERS_LIST =[]

for i in range(1, 1000001):
  user = {
      "userId": i,
      "name": f"name_{i}",  
      "surname": f"last_{i}",  
      "username": f"username_{i}",
      "email": f"user{i}@example.com", 
      "isAdmin": random.choice([True, False]),
      "techSkills": random.sample(TECH_LIST, random.choice(list(range(0, 5))))
  }

  USERS_LIST.append(user);


json_string = json.dumps(USERS_LIST, indent=2)

with open("users.json", "w") as f:
   f.write(json_string)