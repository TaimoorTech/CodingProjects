x = [0:0.1:10];
y = sin(x)./(x); 
u= (1./((x-1).^2))+x;
v = ((x.^2)+1)./((x.^2)-4);
z = (((10-x).^(1/3))-1)./((4-(x.^2)).^(1/2));

subplot(2,2,1), plot(x,y);title('y')
%ylabel('y')
%xlabel('x')
subplot(2,2,2), plot(x,u);title('u')
%ylabel('u')
%xlabel('x')
subplot(2,2,3), plot(x,v);title('v')
%ylabel('v')
%xlabel('x')
subplot(2,2,4), plot(x,z);title('z')
%ylabel('z')
%xlabel('x')
