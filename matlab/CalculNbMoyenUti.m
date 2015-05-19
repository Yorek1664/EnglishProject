function[NbMoy] = CalculNbMoyenUti(arrive,depart, tpsFin)

n = size(arrive);
m = size(depart);

% Calcul du temps d'attente
continu = 1;
i = 1;
j = 1;
%On fait la 1ere itération
nbReq = 0;
tps_prec = 0;
tps_courant = 0;
tab = zeros(100);
while continu == 1
    if (i >= n(2))
        continu = 0;
    end;
    if ( j >= m(2))
       continu = 0;
    end;
    if continu == 1
        %On a un depart
        if(depart(i) < arrive(j))
            tps_courant = depart(i);
            nbReq = nbReq - 1;
            i = i + 1;
        else
            tps_courant = arrive(j);
            nbReq = nbReq + 1;
            j = j + 1;
        end;
        if(nbReq > 0)
            tab(nbReq) = tab(nbReq) + (tps_courant - tps_prec);
            tps_prec = tps_courant;
        end;
    end;
end;

i = 1;
nbClientTot = 0;
while i < size(tab)
    
    nbClientTot = nbClientTot + i * tab(i);
    i = i + 1;
end;
NbMoy = nbClientTot / tpsFin;


    