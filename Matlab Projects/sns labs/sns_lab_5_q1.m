v1=[0 0 0 0 4 4 4 4 0 0 0 0];
v2=[0 0 0 1 2 3 4 3 2 1 0 0];
u=conv(v1,v2);
subplot(2,2,1), stem(v1);
grid on;
subplot(2,2,2), stem(v2);
grid on;
subplot(2,2,3), stem(u);
grid on;