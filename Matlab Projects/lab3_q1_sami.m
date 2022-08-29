subplot(3,2,3),stem(t_s,x1_s);
title('cos1_s');
subplot(3,2,4),stem(t_s,x2_s);
title('cos2_s');

%%reconstruction
x1_r=spline(t_s,x1_s,t);
x2_r=spline(t_s,x2_s,t);

subplot(3,2,5),plot(t,x1_r);
title('cos1_r');
subplot(3,2,6),plot(t,x2_r);
title('cos2_r');


subplot(3,2,3),stem(t_s,x1_s);
title('cos1_s');
subplot(3,2,4),stem(t_s,x2_s);
title('cos2_s');


%%reconstruction
x1_r=spline(t_s,x1_s,t);
x2_r=spline(t_s,x2_s,t);

subplot(3,2,5),stem(t,x1_r);
title('cos1_r');
subplot(3,2,6),stem(t,x2_r);
title('cos2_r');
