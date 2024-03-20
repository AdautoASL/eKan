package br.com.exemplo.ekan.security;

public record RegisterDTO(String login, String password, UserRole role) {
}
