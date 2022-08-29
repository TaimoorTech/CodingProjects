first = -10:10;
y1 = ((0.2).^(first)).*(first>=5);
y2 = ((0.2).^(first)).*(first>=-6);
y3 = y1 + y2;
y4 = 1.*(first==5);
y5 = y4.*y3;
y6 = (20*(0.5).^(first)).*(first>=-4);
figure, stem(first, y6);
grid on;
