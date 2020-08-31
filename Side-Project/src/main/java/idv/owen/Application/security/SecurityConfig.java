package idv.owen.Application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



//启用全局认证机制 ,＠EnableWebSecurity本身即是一個＠Configuration的多組合配置
@EnableWebSecurity 
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	//private final Logger logger=org.slf4j.LoggerFactory.getLogger();
	
	@Autowired
    private MyAuthenctiationFailureHandler myAuthenctiationFailureHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { 

		http
        .authorizeRequests()
        .antMatchers("/login","/static/**").permitAll()
        .anyRequest()
        .authenticated()
        
		.and()
   	    .csrf().disable() //關閉CSRF檢查
   	    .rememberMe()
   	    
        .and()
        .formLogin()
	        .loginPage("/login")        		//指定登录页的路径
	        .loginProcessingUrl("/login")       //指定自定义form表单请求的路径
	        .defaultSuccessUrl("/",true).permitAll()
	        //.failureUrl("/login?error")
            //.successHandler(myAuthenctiationSuccessHandler)
            .failureHandler(myAuthenctiationFailureHandler)
        .and()
        .logout()
        	.logoutUrl("/login?logout").permitAll();

	}
	
	@Autowired
    private UserDetailsService userDetailsService;
//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        return super.userDetailsService();
//    }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
//    	auth.inMemoryAuthentication() //自訂Runtime時的使用者帳號
//    	.withUser("admin")
//    	.password(passwordEncoder().encode("admin")).roles("ADMIN", "USER");
    	 auth.userDetailsService(userDetailsService)
         .passwordEncoder(passwordEncoder());
    }
    
}