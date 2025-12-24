package com.dema.app_gym_progress

class Validations() {

    fun validatePassword(validate: String?): String {
        if (validate == null || validate.isEmpty()) {
            return "Insira uma senha!"
        }

        if (validate.length < 8) {
            return "A sua senha precisa ter 8 ou mais caracteres!"
        }

        if (!validate.contains("[0-9]".toRegex())) {
            return "Sua senha precisa de numeros!"
        }

        if (!validate.contains("[#@!$%&*^()_=+]".toRegex())) {
            return "Sua senha precisa de caracteres especiais!"
        }

        return ""
    }

    fun validateConfirmPassword(firstPassword: String?, secondPassword: String?): String {
        if (secondPassword == null || secondPassword.isEmpty()) {
            return "Insira um senha"
        }

        if (firstPassword != secondPassword) {
            return "As senhas precisam ser iguais"
        }

        return ""
    }

}