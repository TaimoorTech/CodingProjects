%unit step
%n = -5:5;
%x = [zeros(1,8), ones(1,3)];
%stem(n,x);
%axis = ([-12 12 -1 2]);

%unit ramp
%t=-10:10;
%u = [zeros(1,10), ones(1,11)];
%r=t.*u;
%plot(t,r);
%axis = ([-12 12 - 1 2]);

n = -10:10;
x_n = 2.*(0.25).*n;
stem(n,x_n);
