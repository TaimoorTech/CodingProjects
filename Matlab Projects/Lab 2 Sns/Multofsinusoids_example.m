t1=[-5:0.1:0]
y1=2*exp(t1);
t2=[0:0.1:10]
y2=-t2+2;

t3=[-5:0.1:10]
w=cos(30*t3)
v=figure
t=[t1 t2 ]
y=[y1 y2 ]
plot(t,y)
