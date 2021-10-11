import pygame
pygame.init()
pygame.mixer.init()
pygame.mixer.music.load("vaaste.mp3")
pygame.mixer.music.play(loops=1,start=0.0)

while pygame.mixer.music.get_busy():
    pygame.time.Clock().tick(10)

