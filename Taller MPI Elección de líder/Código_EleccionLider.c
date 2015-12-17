/*
Escuela Politécnica Nacional
Facultad de Ingeniería de Sistemas
Computación Distribuida
Integrantes:  Ricardo Ortiz
		   Wilmer Valdiviezo
Paralelo: Gr2
*/

#include <stdio.h>
#include <mpi.h>
#include <string.h>
#include <stdlib.h> 
#include <time.h> 

void lider(int cadena[],int n,int *pos,int *num);
 
int main(int argc, char* argv[])
{
        
	int TAG=123;

	int cantProc=8, idProc,posicion, numMat, i, j, peso;
//        cantProc=8;

	
  	MPI_Status stat;
	MPI_Init(&argc, &argv); 
  	MPI_Comm_size(MPI_COMM_WORLD,&cantProc); 
  	MPI_Comm_rank(MPI_COMM_WORLD,&idProc);	
       
	int pesos[cantProc];
	 //Numero aleatorio para cada procesador	
	srand(time(0)+idProc);  
	peso=rand()% 45;
	pesos[idProc]=peso;

	for(i=0;i<cantProc;i++)
   	{		
		if(idProc!=i)
		{
			MPI_Send(&peso, 1, MPI_INT, i, TAG, MPI_COMM_WORLD);
		}			
	}
	
	for(j=0;j<cantProc;j++)
	{	
		if(idProc!=j)
		{		
			MPI_Recv(&peso, 1, MPI_INT, j, TAG, MPI_COMM_WORLD, &stat);
			pesos[j]=peso;
		}
	}
	if((j==cantProc)&&(i==cantProc))
	{
	lider(pesos,cantProc,&posicion,&numMat);
		
		if(idProc==posicion)
		{
		printf("Procesador: %d con peso: %d, Soy el lider \\o/\n",idProc,pesos[idProc]);
		}
		else
		{
		printf("Procesador: %d con peso: %d, No soy el lider\n",idProc,pesos[idProc]);
		}
	}
  	MPI_Finalize(); 
  	return 0;
}
//funcion lider
void lider(int cadena[],int n,int *posicion,int *numero){
int i,j;
*posicion=0;
*numero=cadena[0];

for (i=0;i<n;i++)
    	{
        	for (j=i+1;j<n;j++)
        	{
            		if (*numero<cadena[j])
			{
				*posicion=j;
				*numero=cadena[j];
			}
        	}
	}
}


