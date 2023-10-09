# Hangman Game

The goal of this game is to guess a secret
word sooner, than you run out of attempts
(you are hanged). Secret word is 
chosen randomly from a file.

Conditions for a valid input:

- input can contain just a letters (numbers and special characters are not allowed)
- if player enters more than one letter, just first letter is considered as input anyway

Game rules:

- at the start of the game, a random secret word is chosen (from attached file) and shown to the player in a form of ***underscores*** as a placeholders for each letter
- a player enter a letter as input in each round
- if a secret word contains that letter, placeholders on all correct positions are replaced with this letter
- if a secret word does not contain that letter, a next stage of hangman is displayed to the player and number of remaining attempts is deducted by 1
- if a player enter a letter, which he already entered before, a game will give a feedback, that this letter was already guessed, remaining attempts are not deducted in this case

Game ends if:

- player guessed a secret word correctly
- player run out of attempts

In a case you found some bugs during a playing, please let me know. \
Have fun :)