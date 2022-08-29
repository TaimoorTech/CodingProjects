%t=[-0.5:0.01:0.5]
%x=cos(pi*t) 
%[y,n]=sigshift(x,t,0.5)
%axis=([-0.5 2 -1 1])
%plot(t,x,'r-',n,y,'g-')  

t=-0.5:0.01:0.5;
x=cos(pi*t);
w=x(2*t);
plot(t,w);