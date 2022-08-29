t=[-2:0.05:2]
x = sin (index * pi * t);
for index = 1:8
    x = sin (index * pi * t);
    subplot(2,4,index),plot(t,x);
    
end
xlabel('time(sec)'),ylabel('Amplitude');