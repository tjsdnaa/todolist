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

### 2. 소스 빌드 및 실행 방법 메뉴얼

1. Visual Studio 실행 후 깃 배쉬 터미널을 엽니다.
2. `npx create-next-app@latest` 명령어로 새 프로젝트를 생성합니다.
3. `npm install axios` 명령어로 Axios를 설치합니다.
4. `git init` 명령어로 Git을 초기화합니다.
5. `git remote add origin https://github.com/tjsdnaa/todolist` 명령어로 원격 저장소를 추가합니다.
6. `git pull origin master` 명령어로 master 브랜치에서 소스를 다운로드합니다.
7. `cd ./my-app` 명령어로 본인이 만든 폴더로 이동합니다.
8. `npm run dev` 명령어로 프로젝트를 실행합니다.

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

### 2. 소스 빌드 및 실행 방법 메뉴얼 (DB 스키마 및 기초 데이터 백업 파일 필수)

1. `git clone` 명령어로 백엔드 브랜치를 받습니다.
   ```bash
   git clone -b back-end https://github.com/tjsdnaa/todolist
   cd todolist
