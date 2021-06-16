'''
WAP to find the prime factor of a number. If a factor of a number is prime number then
it is prime factor
'''
print "Enter number" #this will be your first output result where you will add your number
number = input() #Python has an input function which lets you ask a user for some text input. You call this function to tell the program to stop and wait for the user to key in the data.
i = 2 #we take 1=2 because you always start factorial from 2
while i <= number: #while loop i<=number because if number is best then 2 the loop will execute if not loop terminated
  #Checking if prime or not 
  j = 2    
  count = 0 #the counting strat from 0
  while j <= i: #if j=2 or > 2 so count will start like 1+1=2 2+1=3 
    if i%j == 0:
      count = count+1
    j = j+1
  #if count > 1 then it is not prime
  #if prime and factor(number%i==0) then it is prime factor
  if count <= 1 and number%i == 0:
    print i
  i = i+1
