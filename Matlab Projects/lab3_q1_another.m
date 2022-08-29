SR1=100;  %sampling rate
dt1=1/SR1  %sampling interval
t1= 0:dt1:1;
x1n=sin(20*pi*t1);
subplot(3,2,1),
stem(t1,x1n);
xlabel('t1');
ylabel('sin20\pit');
SR2=20 ;  %sampling rate
dt2=1/SR2  %sampling interval
t2= 0:dt2:1;
x2n=sin(20*pi*t2);
subplot(3,2,2),
stem(t2,x2n);
xlabel('t2');
ylabel('sin20\pit');
SR3=10 ;  %sampling rate
dt3=1/SR3  %sampling interval
t3= 0:dt3:1;
x3n=sin(20*pi*t3);
subplot(3,2,3),
stem(t3,x3n);
xlabel('t3');
ylabel('sin20\pit');

t=[0:0.001:1];
%u=[0:0.05:1];
%v=[0:0.1:1];
y1=spline(t1,x1n,t);
y2=spline(t2,x2n,t);
y3=spline(t3,x3n,t);
subplot(3,2,4),
plot(t,y1);
subplot(3,2,5),
plot(t,y2);
subplot(3,2,6),
plot(t,y3);