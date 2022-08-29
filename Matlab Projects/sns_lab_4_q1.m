syms t;
A=4;
T=2;
f1 = 2*A*t;
f2= 2*A.*(1-t);
a0=(1/T).*(int((f1),t,-0.5,0.5))+int((f2),t,0.5,1.5);
b0=0;
Cn=a0;
w=(2*pi)./T;
an=(2./T).*(int((f1.*cos(n*w*t)),t,-0.5,0.5)+int((f2.*cos(n*w*t)),t,0.5,1.5));
bn=(2./T).*(int((f1.*sin(n*w*t)),t,-0.5,0.5)+int((f2.*sin(n*w*t)),t,0.5,1.5));
cn=sqrt(an.^2+bn.^2);
cn=[Cn cn];
theta0=atan(-b0/a0);
thetan=theta0;
n=0:7;
subplot(211),plot(n,'o'),grid, xlabel('n'),ylabel('C_n'),title('Fourier Series')
subplot(212),plot(n,thetan,'o'),grid,xlabel('n'),ylabel('\theta_n (rad)')
