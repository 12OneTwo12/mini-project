# Java와 MySQL를 이용한 기프티콘 생성 및 관리 시스템(기획)  
  
  2022년에 진행했던, 미니 프로젝트의 경험을 공유하고자 포스팅을 남깁니다.  
  이 프로젝트는 정정일, 윤종현, 박철련, 최지웅 총 4명으로 진행했습니다.    
  
  프로젝트 기간: 2022년 8월 8일 ~ 2022년 8월 11일  
  
### 목차  
  
* #### [[ 사용기술 ]](#사용기술)  
* #### [[ 개발의 필요성 ]](#개발의-필요성)  
* #### [[ 개발 목표 및 목적 ]](#개발-목표-및-목적)  
* #### [[ 시스템의 기능 ]](#시스템의-기능)  
* #### [[ 기대 효과 ]](#기대-효과)  
* #### [[ 느낀 점 ]](#느낀-점)  
    
--------------------------------------------------------------------------------------------------------------------------------------------------- 
 
* ### 사용기술 
  
  * java, MySQL
    
* ### 개발의 필요성  
  
  * 디지털 사회에 가까워질수록 사람들이 직접 만나서 선물을 주기보다 쉽고 간편하게 줄 수 있고 부담이 적으며,   
  사용하기 쉬운 기프티콘을  서로에게 기프티콘을 선물하는 경우가 많아졌다.   
    
  * 이러한 기프티콘을 사용자가 보다 간편하고 편리하게 유지 및 관리할 수 있는 시스템의 필요성이 높아진다.  
    
* ### 개발 목표 및 목적  
  
  * Java, MySQL을 이용하여 사용자가 기프티콘을 간편하게 잔액 조회나 사용 내역조회, 기프티콘 합산 등 손쉽게 관리할 수 있는 시스템을 개발한다.  
  
  * 개발 목적  
  ```  
  1.관리자가 기프티콘 및 결제 내역, 잔액, 유효기간 등 데이터의 체계적 관리

  2.잔액 조회 기능과 사용 기능, 기프티콘 결제 기능, 합산 기능 등을 구현하여 사용자가 보다 편리하게 기프티콘을 이용할 수 있게 구현

  3.사용자가 언제든지 잔액 조회 및 결제내역을 확인할수 있게 구현
  ```
 
* ### 시스템의 기능  
  
  * #### 기프티콘 생성  
       
    #### 구매자  
      
      * 무작위 12자리 숫자 만든 후 결제 금액 등록 및 결제 시기에 따라 유효기간 등록 및 생성된 일련번호 출력 
      
    #### 사용자  
      
      * 사용 및 유효기간, 주문번호, 사용처, 잔액 조회, 결제 내역 조회 가능
        
  * #### 기프티콘 사용    
     
    * 기프티콘 사용시 보유 금액(잔액)에서 차감 및 결제 내역 테이블에 구입 항목, 결제 시간, 결제 금액, 개수 등 등록 
    -> 성공 시 '결제 되었습니다' 출력 
    -> 실패 시 결제 반려 사유 출력 ex) 잔액 부족, 유효기간 만료
      
  * #### 기프티콘 잔액 조회   
    
    * 기프티콘 일련번호 입력시 일련 번호에 따라 지니고 있는 보유 금액 값 조회 및 출력
      
  * #### 기프티콘 결제 내역 조회
    
    * 기프티콘 사용시 등록되었던 결제 금액, 구입 항목, 결제 시간, 개수 등 조회 및 출력  
      
  * #### 기프티콘 합산  
    
    * 두개 이상의 기프티콘 소지시 두개의 일련번호를 입력하면 두 기프티콘의 보유 금액(잔액)을 합산한 
      새로운 기프티콘 생성 및 저장, 기존 기프티콘 2개 삭제 후 새로운 기프티콘 일련번호 출력  
      
* ### 기대 효과   
  
  * 사용자가 보다 편하게 기프티콘의 잔액 및 결제내역을 조회할 수 있게된다.  
    
  * 관리자가 구매 현황 및 사용 현황을 체크해 더 세심한 관리를 기대할 수 있다.  
    
  * 기프티콘 일련 번호만 알고 있으면 다양하게 손쉽게  가능 해진다.  
    
* ### 느낀 점
  
  * 정정일  
    
        이번 프로젝트가 나에게는 첫 프로젝트였습니다.
        생각보다 협업이라는 개념이 가져다주는 즐거움을 크기도 했고 어렵다고 느껴지는 부분도 있었습니다.
        처음으로 느껴보는 내가 주체적이게 무언가를 만들어가는 프로그래밍 과정은 처음에는 막막했지만 진행하면서 쌓여가는 경험과 코딩들이 상당한 만족감과 즐거움을 가져다 주었습니다.
        하기전에는 쉬울거라 생각했던 부분들도 막상 내가 직접하니 생각보다 쉽지 않았고, 그만큼 소중한 경험을 했다는 생각이 드는 프로젝트였습니다.
        

  * 박철련
        
        코딩을 배우고나서 처음으로 하는 프로젝트였는데, 내가 배웠던 언어로 무언가를 만들어가는 과정이 마치 레고로 상상했던 것을 만드는 과정과 흡사해서 즐거움 경험을 했습니다.
        구현하기전에 생각했던 부분이 만들때는 만만하지 않았고, 쉽다고 생각했던 부분이 오히려 더 오래걸리고, 어렵다고 생각했던 부분이 쉽게 만들어지는 경험을 했습니다. 
        하지만 코드를 짜기전에 아웃라인을 만들어 놓고 하는 것은 실제 만들때와 다르더라도 계속 올바른 방향성을 생각하게끔 만들어줘서 꼭 필요하다고 느껴졌습니다.
        첫 프로젝트에 좋은 경험을 한것같아서 좋았습니다.

  * 윤종현
        
        프로젝트 협업을 하면서 내가 많이 부족하다는것을 느꼇고.  귀찮으셨을 수도 있지만 모르는 부분을 질문하면 하나하나 알려주셔서
        너무 고마웠습니다. 조원 분들 처럼 열심히 해서 다른 사람들에게 도움이 되고 싶다는 생각이 들었습니다. 
        에러가 나거나 막히는 부분이 있을때 조원 분들이 더욱 열심히 하는 모습을 보고 자극을 받았습니다. 
        이번 프로젝트를 하면서 프로그래머로 한층 더 성장할 수 있는 좋은 경험 이였습니다.


* ### 동작 과정
  
    ![image url](https://github.com/12OneTwo12/mini-project/blob/main/plan/ezgif.com-gif-maker.gif?raw=true)  
