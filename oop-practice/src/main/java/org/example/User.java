package org.example;


public class User {
    private String password;

    public void initPassword(PasswordGenerator passwordGenerator){
        // as-is 방식 높은결합
//        RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();

        // to-be 방식 낮은결합
        //인터페이스를 먼저 구현하고 generatePassword()메서드를 다 다르게쓸수있음
        // wrongfixed,correctfixed,random 방식 다 PasswordGenerator 인터페이스를 implement하므로
        //PasswordGenerator인터페이스의 메서드인 generatePassword() 를 다 다르게 정의가능.
        String password = passwordGenerator.generatePassword();

        //랜덤으로 생성된 패스워드의 길이가 8이상 12이하 이면 paswword에 그 랜덤패스워드를 저장한다.
        if (password.length() >= 8 && password.length() <= 12){
            this.password = password;
        }
    }

    public String getPassword() {
        return password;
    }
}
