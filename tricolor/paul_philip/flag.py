import pygame

x = 0
dirt = 5
running = 1
barheight = 124
screen = pygame.display.set_mode((900, 600));

barcolor_up = []
for i in range(1, 63):
 barcolor_up.append((i*4, i*4, i*4))
for i in range(1, 63):
 barcolor_up.append((255-i*4, 255-i*4, 255 - i*4))
barcolor_mid = []
for i in range(1, 63):
 barcolor_mid.append((i*4, i*4, i*4))
for i in range(1, 63):
 barcolor_mid.append((255-i*4, 255-i*4, 255 - i*4))
barcolor_down = []
for i in range(1, 63):
 barcolor_down.append((i*4, i*4, i*4))
for i in range(1, 63):
 barcolor_down.append((255-i*4, 255-i*4, 255 - i*4))
while running:
 event = pygame.event.poll()
 if event.type == pygame.QUIT:
     running = 0

 #screen.fill((0, 0, 0))
 for i in range(0, barheight):
     pygame.draw.line(screen, barcolor_up[i], (x+i, 0), (x+i, 599))
     pygame.draw.line(screen, barcolor_mid[i], (x+i, 0), (x+i, 599))
     pygame.draw.line(screen, barcolor_down[i], (x+i, 0), (x+i, 599))

 x += dirt
 if x  > 899 or x < 0:
     x = 0

 pygame.display.flip()
