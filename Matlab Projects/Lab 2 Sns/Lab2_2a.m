n = -10:10;
y1 = (n.^2).*(n>=-5);
y2 = (n.^2).*(n>=6);
y3 = 10.*(n==0);
y5 = 20*(0.5).^n.*(n>=4);
y6 = 20*(0.5).^n.*(n>=10);
final_y = y1 -y2 + y3 + y5 - y6;
figure, stem(n, final_y);
grid on;
