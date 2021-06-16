'''
Run a program that will takes a number and reverses it with the help of input function

1. Take the value from the user in the type integer and store the value a variable

2 here we are using while loop, get each digit of the number and store the reversed number in another variable

3. Print the reverse of the number

4. Exit the program.n int(input("Enter number ")) rev=0 while(n>0) dig n10 rev-rev 10+dig n10 print Reverse of the number rev)
'''
number=int(input("Enter number to reverse: ")) #taking the user input User must first enter the value and store it in a variable number.
reverse=0 #define is initial value 
while(number>0): #use while loop no number take less then.The while loop is used and the last digit of the number is obtained by using the modulus operator.

    dig=number%10  #The last digit is then stored at the one’s place, second last at the ten’s place and so on.
    rev=rev*10+dig #The last digit is then removed by truly dividing the number with 10.
    number=number//10# afterThis loop terminates when the value of the number is 0.
print("Reverse of the number is:",reverse) # The reverse of the number is then printed.
