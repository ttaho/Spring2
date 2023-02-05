package org.example;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PasswordValidatorTest {

    @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다.")
    @Test
    void validatePasswordTest() {
        assertThatCode(() ->PasswordValidator.validate("serverwizard"))
                .doesNotThrowAnyException();
    }

    @DisplayName("비밀번호가 8자 미만 또는 12자 초과하는 경우 IllegalArgumentException 예외가 발생한다.")
    @ParameterizedTest //이걸 넣어주면 ValueSoruce같은 데이터소스를 사용가능 @csvSource, @MethodSource 등등
    @ValueSource(strings = {"aabbccc","aabbccddeeffg"}) //경계값인 문자길이7,13인값들을 확인해주기 위함
                                                        //이렇게하면 파라미터인 password에 위의 두값들이 들어가며
                                                        //테스트해줌
    //@Test
    void validatePasswordTest2(String password){
        assertThatCode(() -> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }
}
