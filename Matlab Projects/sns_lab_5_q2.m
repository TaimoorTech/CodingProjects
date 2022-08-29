t=-10:10;
x=(1).*(t>=0&t<=2);
h1=(0.5).*(t>=0&t<=2);
h2=(1).*(t>=4&t<=6);
h=h1+h2;
subplot(2,2,1), stem(x);
grid on;
subplot(2,2,2), stem(h);
grid on;