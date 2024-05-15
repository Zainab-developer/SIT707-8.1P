package web.service;

import org.junit.Assert;
import org.junit.Test;
import web.service.LoginService;

public class LoginServiceUnitTest {

    @Test
    public void testValidLogin() {
        Assert.assertTrue(LoginService.login("ahsan", "ahsan_pass", "1990-01-01"));
    }

    @Test
    public void testInvalidUsername() {
        Assert.assertFalse(LoginService.login("invalidUser", "validPass", "1990-01-01"));
    }

    @Test
    public void testInvalidPassword() {
        Assert.assertFalse(LoginService.login("validUser", "invalidPass", "1990-01-01"));
    }

    @Test
    public void testInvalidDateOfBirth() {
        Assert.assertFalse(LoginService.login("validUser", "validPass", "2024-01-01")); // Invalid date
    }

    @Test
    public void testInvalidUsernameAndPassword() {
        Assert.assertFalse(LoginService.login("invalidUser", "invalidPass", "1990-01-01"));
    }

    @Test
    public void testInvalidUsernameAndDateOfBirth() {
        Assert.assertFalse(LoginService.login("invalidUser", "validPass", "2024-01-01"));
    }

    @Test
    public void testInvalidPasswordAndDateOfBirth() {
        Assert.assertFalse(LoginService.login("validUser", "invalidPass", "2024-01-01"));
    }

    @Test
    public void testAllInvalid() {
        Assert.assertFalse(LoginService.login("invalidUser", "invalidPass", "2024-01-01"));
    }

    @Test
    public void testInvalidUsernameAndValidPassword() {
        Assert.assertFalse(LoginService.login("invalidUser", "ahsan_pass", "1990-01-01"));
    }

    @Test
    public void testValidUsernameAndInvalidPassword() {
        Assert.assertFalse(LoginService.login("ahsan", "invalidPass", "1990-01-01"));
    }

    @Test
    public void testValidUsernameAndValidPasswordButInvalidDateOfBirth() {
        Assert.assertFalse(LoginService.login("ahsan", "ahsan_pass", "2024-01-01"));
    }
}
