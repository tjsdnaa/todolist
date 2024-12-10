# ToDoList 프로젝트

## 설치

### 1. Visual Studio 설치
- Visual Studio를 설치합니다.

### 2. MySQL 설치
- MySQL을 설치하고, `ID: root`, `Password: 1234`로 설정합니다.

### 3. IntelliJ 설치
- IntelliJ IDEA를 설치합니다.

---

## GitHub

### 주소
- [https://github.com/tjsdnaa/todolist](https://github.com/tjsdnaa/todolist)

### 브랜치
- 프론트엔드 브랜치: `front-end`
- 백엔드 브랜치: `back-end`

---

## 프론트엔드

### 1. 자신이 개발한 앱에 대한 설명
- ToDoList를 개발했습니다. CRUD 기능 및 마감일 임박 시 알림 기능, 마감일이 빠른 순으로 순서 배정하는 기능을 개발했습니다.
- (백엔드를 먼저 실행해야 프론트엔드 실행이 가능합니다.)

### 2. 소스 빌드 및 실행 방법 메뉴얼

1. Visual Studio 실행 후 깃 배쉬 터미널을 엽니다.
2. `git init` 명령어로 Git을 초기화합니다.
3. `git remote add origin https://github.com/tjsdnaa/todolist` 명령어로 원격 저장소를 추가합니다.
4. `git pull origin master` 명령어로 master 브랜치에서 소스를 다운로드합니다.
5. `npm install`,`npm install axios` 명령어로 Axios를 설치합니다.
6. `npm run dev` 명령어로 프로젝트를 실행합니다.

#### 2-1. 만약 위 방법으로 실행되지 않을 경우
1. Visual Studio 실행 후 깃 배쉬 터미널을 엽니다.
2. `npx create-next-app@latest` 명령어로 새 프로젝트를 생성합니다.
3. `npm install axios` 명령어로 Axios를 설치합니다.
4. GitHub에서 코드를 압축 해제하고, `app` 폴더에 있는 데이터를 복사하여 붙여넣기 후 실행합니다.

### 3. 주력으로 사용한 컴포넌트에 대한 설명 및 사용 이유
- `<List/>` 컴포넌트를 주력으로 사용했습니다. ToDoList의 게시글을 보여주기 위해 사용했습니다.

### 4. 백엔드 과제와 셋트로 수행할 시 가산점 부여
- 백엔드 과제도 수행했습니다.
  - 기본 기능 이외에 아이디어가 추가된 1개 이상의 기능이 동작해야 합니다.
  - 알림 기능: ToDoList 마감일 5분 전 알림 기능을 만들었습니다.

---

## 백엔드

### 1. 자신이 개발한 앱에 대한 설명
- ToDoList를 개발했습니다. CRUD 기능 및 마감일 임박 시 알림 기능, 마감일이 빠른 순으로 순서 배정하는 기능을 개발했습니다.
- (백엔드를 먼저 실행해야 프론트엔드 실행이 가능합니다.)

### 2. 소스 빌드 및 실행 방법 메뉴얼 (DB 스키마 및 기초 데이터 백업 파일 필수)

1. `git clone` 명령어로 백엔드 브랜치를 받습니다.
   ```bash
   git clone -b back-end https://github.com/tjsdnaa/todolist
   cd todolist

### 3. 주력으로 사용한 라이브러리에 대한 설명 및 사용 이유 기입
- JPA라이브러리를 주력으로 사용했습니다. JPA는 객체와 RDBMS 간의 매핑을 위한 표준 API입니다. 객체관계 매핑을 지원하여 개발자가 RDBMS 데이터를 객체형대로 처리할 수 있고 반대로 객체를 데이터베이스의 저장하기 쉽게 할 수 있도록 도와주는 라이브러리입니다. IT교육에서 배우기도 했고 유지보수성 용이하고 편리하다 생각해서 사용했습니다.

### 4. Api 명세 작성 필수 → Swagger 등 사용해도 무방함
- (API명세를 정확히 어떻게 작성하는 지 몰라 일단 작성해봤지만 양해부탁드립니다.)
- (로그인)
 1. 로그인 되어있는지 확인
   - 메서드 : GET , 요청 URL : http://localhost:9090/login
   - 응답 :{userId : '사용자' , password : '비밀번호' , name : '이름'}
 2. 로그인 하기 
   - 메서드 : POST , 요청 URL : http://localhost:9090/login
   - 요청 :{userId : '사용자' , password : '비밀번호'}
 3. 로그아웃
   - 메서드 : GET , 요청 URL : http://localhost:9090/logout
   -응답 :boolean
 (TODOLIST)
 1. 해당 아이디의 전체 todolist 출력
   - 메서드 : GET , 요청 URL : http://localhost:9090/todoList
   -응답 :{
  "listId": 1,
  "title": "",
  "content": "",
  "closingDate": "2024-12-15T18:00:00",
  "userId": "user123"
}
 2. todolist 생성
   - 메서드 : POST, 요청 URL : http://localhost:9090/todoList
   -응답 : {
  "listId": 1,
  "title": "",
  "content": "",
  "closingDate": "2024-12-15T18:00:00",
  "userId": "user123"
}
 3. todolist 삭제
   - 메서드 : POST, 요청 URL : http://localhost:9090/todoList/list/{i}
   - 응답 : 없음
 (회원가입)
 1. 회원가입
   - 메서드 : POST, 요청 URL : http://localhost:9090/join
   - 요청 : :{userId : '사용자' , password : '비밀번호' , name : '이름'}
### 5. 테스트케이스 작성 필수
테스트 아이디 | 시나리오 | 입력데이터 
1. | 회원가입 하기 | 
{userId : '사용자' , password : '비밀번호' , name : '이름'}
2. | 로그인 | 
{userId : '사용자' , password : '비밀번호' }
3. | 투두리스트 출력 | 
{
  "listId": 1,
  "title": "",
  "content": "",
  "closingDate": "2024-12-15T18:00:00",
  "userId": "user123"
}
4. | 투두리스트 삭제 | (없음)

### 6 기본 CRUD 업무 이외에 추가적인 업무 Api 1개이상 필수 (Ex -> 일정 공유 기능)
- TODOLIST의 마감일 순서에 따라 리스트의 우선순위 배정했습니다.
- 로그인 기능 추가했습니다.
