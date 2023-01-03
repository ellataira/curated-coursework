#! /usr/bin/env python3

import random 
import argparse

parser = argparse.ArgumentParser(
        description = "Generate a secure, memorable password using the XKCD method")

parser.add_argument("-w","--words",type=int, default=4,
                        help='include WORDS words in the password (default=4)')

parser.add_argument("-c", "--caps", type=int, default=0,
                        help='capitalize the first letter of CAPS random words (default=0)')

parser.add_argument("-n", "--numbers", type=int, default=0,
                        help='insert NUMBERS random numbers in the password (default=0)')

parser.add_argument("-s", "--symbols", type=int, default=0,
                        help='insert SYMBOLS random symbols in the password (default=0)')

args = parser.parse_args()

password = []

possibleSymbols = ["~", "!", "@", "#", "$", "%", "^", "&", "*",".", ":", ";"]
possibleNumbers = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]

def getRandomWord():
    return random.choice(open("words.txt").read().split())

while args.words > 0:
        if 0 < args.caps < args.words:
                password.append(getRandomWord().capitalize())
                args.caps -= 1
                args.words -= 1
        else:
                password.append(getRandomWord())
                args.words -= 1

for s in range(args.symbols):
	password.append(random.choice(possibleSymbols))

for n in range(args.numbers):
	password.append(random.choice(possibleNumbers))

random.shuffle(password) 

print("".join(password))

