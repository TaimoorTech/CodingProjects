t=-10:1:10;
ramp=t.*(t>=0);
tri=tripuls(t);
subplot(2,2,1), stem(ramp);
title('RAMP');
grid on;
subplot(2,2,2), stem(tri);
title('TRIANGULAR');
grid on;