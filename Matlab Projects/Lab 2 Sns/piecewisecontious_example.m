t=[-1:0.01:2];
h=1*[t>=-1 & t<=0];
h=h+[-1*(t>0 & t<=2)]
plot(t,h,'linewidth',2)
grid
axis([-2 3 -1.2 1.2])
