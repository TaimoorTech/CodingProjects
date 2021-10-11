f=open('WORDS.txt','a')
word_list=f.read()
word_list=word_list.split()
secret_word=random.choice(word_list)
print ('The selected word has',len(secretword),'alphabets')
#Necessary initializations
no_of_guesses=6
alphabets='abcdefghijklmnopqrstuvwxyz'
guessed_so_far=' _ ' * len(secret_word)
found='' #string containing all the letters already found by the player
while true:
 #Printing messages and taking a letter as input from the player
    print ('\n\nYou have',no_of_guesses,'guesses remaining')
    print('Guessed so far:',guessed_so_far)
    print('Letters available:',alphabets)
    letter=input('Guess a letter from the available alphabets:')
    letter=letter.lower
 #checking if the input letter is correct,
 #updating relevant strings and number of guesses if needed
    if letter in alphabets:
        if letter in secret_word:
            guessed_so_far=update_guessed_so_far(letter,guessed_so_far)
            found+=letter
            if '_' not in guessed_so_far:
                    Print('\nYayyy!! YOU WIN!!')
                    #Print score

        else:
            print('\nWrong letter!!')
            if no_of_guesses>0:
                no_of_guesses+=1
            else:
                print('\nYour chances are up:((')
                print('The correct word is',alphabets)
                break;
        alphabets=remove_from_alphabets(letter,alphabets)
 #if alphabet and already guessed
    elif letter not in alphabets or letter.isalpha():
        print('\nAlready guessed')
 #if the player enters a digit or any special character
    Else:
        print'\nOnly digits allowed!'
