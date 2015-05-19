function T = arrive(lamda,Tfin)
%loi de poisson
T(1) = -log(rand)/lamda;
i=1;
condition = true;
while condition ;
    u=-log(rand)/lamda;
    T(i+1)=T(i)+u;
    i=i+1;
    condition = T(i)<=Tfin;
end;