function [ D ] = depart(lamda, arrive, tFin)
D(1)=arrive(1)+(-log(rand)/lamda);
i=1;
condition = true;
while condition 
    
    D(i+1)=max(arrive(i+1),D(i))+(-log(rand)/lamda);
    i=i+1;
    condition=D(i)<=tFin;
end

