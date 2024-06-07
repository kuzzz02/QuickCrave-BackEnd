package com.quickcravebackend.middleware;

import com.alipay.api.AlipayApiException;
import org.springframework.web.bind.annotation.*;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

@RestController
@CrossOrigin
@RequestMapping("/alipay")
public class AlipayController {
    @PostMapping("/pay")
    public String pay() {
        AlipayClient alipayClient = new DefaultAlipayClient(
                "https://openapi.alipay.com/gateway.do",
                "9021000137608403",
                "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCxIm6jvHdMJ7Rk54Ddj/P9LSxyDNze4TBcL2pbJWwt762oYMYdf3OApoVdTZw9f/2wICRYFOVj22wU97cs+OUEUGdcZz1Dlq3qthAJtBXmSFSER3mLqQNuefXeW78Hyex/3WyVQqW6drlxlEwD4wsvOorDK1x59GWsU94ME4gy36dzf4Q6qNzc/z3UzqtPxiqsn1JMvXFUwl2jAwVcpQLJA8Aj3wjLxCFnfRR6/UW+uFYZjwNUXFH57Zqv5uOpVtkFyTZ5niDMpVAomZ/Au+isa1qmE7/cvyuEcerlYtPdgsEWGFZEzgK/2GT/u8EKcDMIXk4JpLOI3DIxTZZe2ILfAgMBAAECggEAfAhCNMDJQDglJuq732jnTgaNsqazGhXQyRwiewQvRdMoZFivIQSXmiQACp9HogC3YNaA3HR1U4DXo675QrJdmrG6Toez7FncGhe2DzVciE1pcN6ji1mjn34i3bqcfxWzVq1zVOjAJ1ru60sOF0KqGD4D4DnCnVq2vv5S413h5sxueHeS/ula8bPWLZ1+peZZIDDu5NaCHspp0Oc3brMMgSVPhdHJyVWBAXxlOhbppZX3VSFuT3SObr/bFfFpAYoGF6cv/GjII7o4iv4Hwod+wYzG6cuiC+ZsU3O5J5zJm6tqfnIFuph+6Mn1rO58hbeksUl+80Sz6pZi5aYh1wVNIQKBgQDd7m5fE9ZhXGnNA/D1F+SP/jnZQtenBSUQOH6Lfa6GKLcI8udrlBfG1VfoC863pGktC/dYoqdUa9rWh7unhlq8I1vwo8xaKhe5NzX9fG/YZKLXoXYliDyZ84mPN1Ia9j/rO7slCtHKK4b6cZ91pFbC9MS94akC0KjE+fNB6pRd9wKBgQDMU40rrQSctgtWrYWrZjYRqzo4xmOl+ecMLE+RMJXqT4jK/SVzI0J7ZpdXIT+mNeRK2mCFMK5oi18mFYLsrnn6cbub4ZMjBjH8+qhVzdAOZnITNZp9q4tH87yya0d2o4Jlg0TKa+DsHMxU4g5F6IwkTavtKFpw6nv79cyPLcToWQKBgQCElthV8VIZJM8I7xvcMgQZivcgt/CDFm3IPRhNWi8Uc+q2a/iaqwVxgzBbsAI2cQFtKkMCL1rs8urxVHJmabx3vmBFanbCP3eg7j1RTjC8BZPMY+hkD/q0t20tpQ1mkkwpy6vJO6eOs2aW5Z8w95fmLboE/3ar+eF6nSIZ9X3ijQKBgQCnwv4I20ELLkj2/PfgN8azESR3kyQkFaBHlWYq7npYbL8C84A5Hb0rNpuR1WG+JUdw0gYntUWt3qjbyxO5IrRSFemU3kwBmMeYT3HBKX/nIuQMs5lKD3wHMq8+yuhdF3krwfDMRnDhS+/UzdosOfg+omtECDrhtRThVfqDoG+o2QKBgQCb/es5oWm6CvwEs7NAyKQpaD4G05JnFPdYTmiq7Q58AQHWyJOjOMH9CeRvwpRUCVWtE/dUnHE5jViBnSwaeLsLxKc6TX+se6Emz2P7wtN139c6jUpImCMCbXaMGp9RnPyb8BrR0sJYaO6de3iIBzkf3+IfPz6S611FhInZ7wPqtg==",
                "json",
                "UTF-8",
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkUP4xIwHrcA9KkKZlDudkjKlc89JZxrRKHLJr1U6xOSZIMc5bOMutSc15iW6iNekBiKjg8sz7ycfs1P+2/S/uWWUO1R7QC4GkrLNw4vLjMjIj5vBVH+poCBgACzN4FOk1BPyMwk86aRTM64hcbV3Oowa6qoNQbE8P/FRt/naiE56NX2vXAjwktXqPF4ERtjwKdVbldtzQehHM+DZzegLyFprz8iTe2SVxExfL6P1zJVAm/fe60lzNWn4Y5VZiHwWyUifqEwDyATgHE2Yqz2sloCQGl9ZT0D1CWGDbzkU68XOWq26btjoeRyozHi9UopOpMUt821BF10+OeEBHTAxxQIDAQAB",
                "RSA2");
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl("https://8.130.37.157:12581/alipay/return");
        alipayRequest.setNotifyUrl("https://8.130.37.157:12581/alipay/notify");

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ "123456" +"\","
                + "\"total_amount\":\""+ "99.99" +"\","
                + "\"subject\":\""+ "TEST" +"\","
                + "\"body\":\""+ "TEST GOODS" +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        String result = "";
        try {
            result = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
            throw new RuntimeException("failure");
        }
        return result;
    }

    @GetMapping("/return")
    public String returnUrl() {
        return "success";
    }

    @PostMapping("/notify")
    public String notifyUrl() {
        return "success";
    }
}
