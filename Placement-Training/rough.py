""" TCS NQT QUESTION
Problem Statement
consider the following questions

1, 2, 1, 3, 2, 5, 3, 7, 5, 11, 8, 13, 13, 17, ... """


def prime(n):
    while(True):
        isPrime = True
        for i in range(2, int(n**0.5)):
            if n%i == 0:
                isPrime = False
                break
        if isPrime:
            print(n , " ")
            n += 1
            break
        num += 1


print(prime(97))