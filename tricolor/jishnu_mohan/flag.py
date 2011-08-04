from Tkinter import *
import math

def draw_point(color, x, y):
    r,g,b = color
    pic.put("#%02x%02x%02x" % (r,g,b),(x,y))
    return

def draw_line(x0, y0, x1, y1, color):
    steep = abs(y1 - y0) > abs(x1 - x0)
    if steep:
        x0, y0 = y0, x0  
        x1, y1 = y1, x1
    if x0 > x1:
        x0, x1 = x1, x0
        y0, y1 = y1, y0
    if y0 < y1: 
        ystep = 1
    else:
        ystep = -1

    deltax = x1 - x0
    deltay = abs(y1 - y0)
    error = -deltax / 2
    y = y0
    for x in range(x0, x1 + 1):
        if steep:
            draw_point(color, y, x)
        else:
            draw_point(color, x, y )
                
        error = error + deltay
        if error > 0:
            y = y + ystep
            error = error - deltax
            
def mid(xc,yc,r,color):
        x=0
        y=r
        p=1-r
        while(x<y):
                if(p<0):
                        x=x+1
                        p=p+2*x+1
                else:
                        x=x+1
                        y=y-1
                        p=p+2*(x-y)+1
                draw_point(color,xc+x,yc+y)
                draw_point(color,xc-x,yc+y)
                draw_point(color,xc+x,yc-y)
                draw_point(color,xc-x,yc-y)
                draw_point(color,xc+y,yc+x)
                draw_point(color,xc-y,yc+x)
                draw_point(color,xc+y,yc-x)
                draw_point(color,xc-y,yc-x)
                
root = Tk()
CANVAS_SIZE = 600
pic = PhotoImage(width=CANVAS_SIZE,height=CANVAS_SIZE)
lb = Label(root,image=pic)
lb.pack()

margin = CANVAS_SIZE / 40

xcenter = int(CANVAS_SIZE / 2)
ycenter = int(CANVAS_SIZE / 2)
line_length = ((CANVAS_SIZE / 12) - margin)

for i in range(xcenter-150,xcenter-50):
    draw_line(xcenter-250, i, xcenter+250, i, color=(244,196,48))

for i in range(xcenter-50,xcenter+50):
    draw_line(xcenter-250, i, xcenter+250,i, color=(255,255,255))

for i in range(xcenter+50,xcenter+150):
    draw_line(xcenter-250, i, xcenter+250, i, color=(51,153,51))

n_lines = 24
angle_step = (2 * math.pi) / n_lines

for i in range(n_lines):
    theta = angle_step * i
    xstart = int(margin * math.cos(theta)) + xcenter
    ystart = int(margin * math.sin(theta)) + ycenter
    xend = int(line_length * math.cos(theta)) + xcenter
    yend = int(line_length * math.sin(theta)) + ycenter
    draw_line(xstart, ystart, xend, yend, color=(0,0,0))
    
for i in range(0,margin):
    mid(xcenter, ycenter,i,(0,0,0))

for i in range(line_length,line_length+4):
    mid(xcenter, ycenter,i,(0,0,0))

root.mainloop()
