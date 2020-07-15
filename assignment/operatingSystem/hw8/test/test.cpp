#include <stdio.h>
   #include <stdlib.h>
   #include <string.h>
   #define MAX 50
  
   typedef struct Command {
       //char action; //a : request, b : release, c : exit, -> 큐에 들어가는 것은 요청뿐임
       int Play_Process;
       int *resource;
      Command *next;
 } Command;
 
  typedef struct Queue {
      Command *front, *rear;
      int Q_count;
  } Queue;
 
  void enQueue(Queue *q, Command item, int R_num) { //큐삽입함수
      int i;
      Command *temp = (Command*)malloc(sizeof(Command));
      temp->resource = (int*)malloc(sizeof(int)*R_num);
 
      temp->Play_Process = item.Play_Process;
      for(i = 0 ; i < R_num ; i++) {
          temp->resource[i] = item.resource[i];
      }
 
      temp->next = NULL;
 
      if(q->Q_count == 0) {
          q->front = temp;
          q->rear = temp;
      }
      else {
          q->rear->next = temp;
          q->rear = temp;
     }
      q->Q_count++;
  }
 
  Command deQueue(Queue *q, int R_num) { //큐삭제함수
      Command *temp = q->front;
      Command item;
      int i;
       item.resource = (int*)malloc(sizeof(int)*R_num);
       item.Play_Process = temp->Play_Process;
      q->front = q->front->next;
 
      for(i = 0 ; i < R_num ; i++) {
         item.resource[i] = temp->resource[i];
      }
 
      q->Q_count--;
 
      return item;
 
  }
 
  void inti_Q(Queue *q) { //큐조기화함수
     q->front = NULL;
      q->rear = NULL;
      q->Q_count = 0;
  }
 
  int Av_Re(int Av[], int Re_Ne[], int c) { //Available과 Request의 비교, Available와 Need의 비교
      int i;
      for(i = 0 ; i < c ; i++) {
          if(Re_Ne[i] > Av[i]) //Need나 Request가 더 크면 오류
              return 0;
      }
      return 1;
  }
 
  void Array_copy1(int temp[], int origin[], int num) { //1,2차원 배열복사 함수 
    int i;
      for(i = 0 ; i < num ; i++) {
          temp[i] = origin[i];
      }
  }
  void Array_copy2(int (*temp)[50], int (*origin)[50], int P_num, int R_num) {
      int i, j;
      for(i = 0 ; i < P_num ; i++) {
          for(j = 0 ; j < R_num ; j++) {
              temp[i][j] = origin[i][j];
          }
      }
  }
 
  //return -> 1 : true, 0 : false
  int Request_Check(int (*All)[50], int (*Ne)[50], int Av[], Command Re, int P_num, int R_num) { //요청의 가능확인 겸 수락
      int i, j;
      int All_temp[MAX][MAX];
      int N_temp[MAX][MAX];
      int Av_temp[MAX];
      int flag[MAX];
     int Next = 1; //다음 프로세스 : 확인변수 1이면 확인하고 0이면 안해도됨  
      for(i = 0 ; i < P_num ; i++) {
         flag[i] = 0; //0이면 확인 안했고, 1이면 확인함
     }

    if(Av_Re(Ne[Re.Play_Process], Re.resource, R_num) == 0) { //Request가 Need보다 큰 경우
         //printf("니드보다 요구가 더 큼 \n");
         return 2;
     }
     
     Array_copy2(All_temp, All, P_num, R_num);
     Array_copy2(N_temp, Ne, P_num, R_num);
     Array_copy1(Av_temp, Av, R_num); //확인할 거 임시배열에 복사

     for(i = 0 ; i < R_num ; i++) { //임시 Need값, Av 감소
         N_temp[Re.Play_Process][i] -= Re.resource[i];
         Av_temp[i] -=  Re.resource[i];
     }
     for(i = 0 ; i < R_num ; i++) { //임시 All값 증가
         All_temp[Re.Play_Process][i] += Re.resource[i];
     }

     //안정한가 불안정한가 확인
     while(Next) {
         Next = 0;
         for(i = 0 ; Next == 0 && i < P_num ; i++) {
             if(flag[i] == 0) { //확인 안했다면
                 if(Av_Re(Av_temp, N_temp[i], R_num) == 0) { //Need와 Av비교
                 }
                 else {
                     Next = 1; //i번째 프로세스가 수락됨
                     for(j = 0 ; j < R_num ; j++)
                         Av_temp[j] += All_temp[i][j]; // i는 할당 받고 푸는 작업을 해야함
                     flag[i] = 1; //i는 확인되었음
                 }
             }
         }
     }

     for(i = 0 ; i < P_num ; i++) {
         if(flag[i] == 0) { //하나라도 확인 안된것이 있다면
             //printf("불안정스러움\n");
             //요청 해주면 안되니 걍 내벼둠
             return 0;
         }
     }

     //printf("안정스러움 \n");
     //안정스러워서 요청 되니깐 각 값들 수정
     for(i = 0 ; i < R_num ; i++) { 
         Ne[Re.Play_Process][i] -= Re.resource[i];
         Av[i] -=  Re.resource[i];
     }
     for(i = 0 ; i < R_num ; i++) { 
         All[Re.Play_Process][i] += Re.resource[i];
     }
     return 1;
 } 

 void Release(int (*All)[50], int (*Ne)[50], int Av[], Command Re, int P_num, int R_num) {
     int i;
     for(i = 0 ; i < R_num ; i++) { //Allocated 감소
         All[Re.Play_Process][i] -= Re.resource[i];
     }
     for(i = 0 ; i < R_num ; i++) { //Need, Available 증가
         Ne[Re.Play_Process][i] += Re.resource[i];
         Av[i] += Re.resource[i];
     }
 }

 int main() {
     int Process_num, Resource_num;
     int Resource_MAX[MAX];
     int Available[MAX];
     int Allocated[MAX][MAX];
     int Max[MAX][MAX];
     int Need[MAX][MAX];
     //int count = 1; //확인
    
     int i, j, temp, Q_count;
     char word[8]; //request가 가장 길므로 7+1 = 8
     Queue Wait_Queue; //wait 큐
     Command C_temp;

     FILE *file = fopen("banker.inp", "rt");
    FILE *file2 = fopen("banker.out", "wt");
     fscanf(file, "%d%d", &Process_num, &Resource_num);
     inti_Q(&Wait_Queue); //큐 초기화

     /////////////////시작!///////////////

     for(i = 0; i < Resource_num; i++) { //Available받기
         fscanf(file, "%d", &Resource_MAX[i]);
     } 

     for(i = 0; i < Process_num ; i++) { //Max 받기
         for(j = 0; j < Resource_num ; j++) {
             fscanf(file, "%d", &Max[i][j]);
         }
     }

     for(i = 0; i < Process_num ; i++) { //Allocated 받기
         for(j = 0; j < Resource_num ; j++) {
             fscanf(file, "%d", &Allocated[i][j]);
         }
     }

     for(i = 0; i < Process_num ; i++) { //Need 생성
         for(j = 0; j<Resource_num ; j++) {
             Need[i][j] = Max[i][j] - Allocated[i][j];
         }
     }

     for(i = 0; i < Resource_num; i++) { //Available 생성
         temp = 0;
         for(j = 0; j < Process_num; j++) {
             temp += Allocated[j][i];
         }
         Available[i] = Resource_MAX[i] - temp;
     }

     C_temp.resource = (int*)malloc(sizeof(int)*Resource_num);
     
     while(1) {
         fscanf(file, "%s", &word);
         fscanf(file, "%d", &C_temp.Play_Process);
         for(i = 0; i < Resource_num ; i++) {
             fscanf(file, "%d", &C_temp.resource[i]);
         }
         
        if(strcmp(word, "request") == 0) { //request 일 경우
             if(Av_Re(Available, C_temp.resource, Resource_num)) { //남은양하고 요구양의 비교
                 temp = Request_Check(Allocated, Need, Available, C_temp, Process_num, Resource_num); //요청의 가능성
                 if(temp == 1 || temp == 2) { //가능 할 때, 요청이 Need보다 클 때
                     //바로 출력
                 }
                 else { //가능 하지 않을 때 명령을 큐에 저장
                     enQueue(&Wait_Queue, C_temp, Resource_num);
                 }

                 //printf("count %d : ", count++);
                 for(i = 0; i < Resource_num ; i++) { //출력
                     printf("%d ", Available[i]);
                     fprintf(file2, "%d ", Available[i]);
                 }
                 printf("\n");
                 fprintf(file2, "\n");
             }
             else { //명령을 큐에 저장
                 enQueue(&Wait_Queue, C_temp, Resource_num);
                 //printf("가능량보다 요구가 더 큼\n");
                 //printf("count %d : ", count++);
                 for(i = 0; i < Resource_num ; i++) { //출력
                     printf("%d ", Available[i]);
                     fprintf(file2, "%d ", Available[i]);
                 }
                 printf("\n");
                 fprintf(file2, "\n");
             }
         }
         else if(strcmp(word, "release") == 0) {//release 일 경우, 반환하고 큐 확인
             int Q_count_temp; //Q안에 명령의 갯수
             //printf("리소스 해제\n");
             Release(Allocated, Need, Available, C_temp, Process_num, Resource_num);

             Q_count_temp = Wait_Queue.Q_count;
             //printf("큐 카운터 : %d \n", Wait_Queue.Q_count);
             for(i = 0 ; i < Q_count_temp ; i++) { //큐 안에 있는 명령들 확인
                 C_temp = deQueue(&Wait_Queue, Resource_num);
                 if(Av_Re(Available, C_temp.resource, Resource_num) == 0) { //요청이 남은양보다 클 경우
                     enQueue(&Wait_Queue, C_temp, Resource_num);
                     continue;
                 }
                 temp = Request_Check(Allocated, Need, Available, C_temp, Process_num, Resource_num);
                 if(temp == 0) { 
                     enQueue(&Wait_Queue, C_temp, Resource_num);
                 //    printf("release 실패 큐 카운터 : %d \n", Wait_Queue.Q_count);
                 }
                 else {
                 //    printf("release 성공 큐 카운터 : %d \n", Wait_Queue.Q_count);
                 }
             }

             //printf("count %d : ", count++);
             for(i = 0; i < Resource_num ; i++) { //출력
                     fprintf(file2, "%d ", Available[i]);
                     printf("%d ", Available[i]);
                 }
             printf("\n");
             fprintf(file2, "\n");
         }
         else //exit 일 경우
             break;

         C_temp.Play_Process = -1; //초기화
         for(i = 0 ; i < Resource_num ; i++)
             C_temp.resource[i] = -1;
     }

     fclose(file);
     fclose(file2);
     return 0;
 }
