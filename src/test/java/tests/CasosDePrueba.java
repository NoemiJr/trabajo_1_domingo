package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CasosDePrueba {
    //Atributos
    private WebDriver driver;
    private WebDriverWait wait;

    private JavascriptExecutor js;

    private String rutaDriver= System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\chromedriver.exe";
    private String propertyDriver = "webdriver.chrome.driver";

    @AfterMethod
    public void posCondicion(){
        driver.close();
    }

    @BeforeMethod
    public void preCondiciones(){

        System.setProperty(propertyDriver,rutaDriver);

        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver,10);

        js = (JavascriptExecutor) driver;

        driver.navigate().to("https://open.spotify.com/");

        driver.manage().window().maximize();
    }
/*
    @Test
    public void CP001_Registro_Fallido_Captcha_en_blanco() {

        By localizadorBtnRegistrase = By.xpath("//button[contains(text(),'Registrarte')]");

        WebElement btnRegistrarse = driver.findElement(localizadorBtnRegistrase);

        btnRegistrarse.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("domingo.saavedra@tsoftglobal.com");

        driver.findElement(By.name("confirm")).sendKeys("domingo.saavedra@tsoftglobal.com");

        driver.findElement(By.name("password")).sendKeys("123454321");

        driver.findElement(By.name("displayname")).sendKeys("Pobre Domingo :D");

        driver.findElement(By.id("day")).sendKeys("28");

        Select cmbMes = new Select(driver.findElement(By.id("month")));

        cmbMes.selectByValue("02");

        driver.findElement(By.name("year")).sendKeys("1991");


       // driver.findElement(By.xpath("//label[@for='gender_option_male']")).click();
        WebElement optionMale = driver.findElement(By.xpath("//label[@for='gender_option_male']"));
        js.executeScript("arguments[0].scrollIntoView();", optionMale);
        optionMale.click();

        driver.findElement(By.xpath("//label[@for='marketing-opt-checkbox']")).click();


        driver.findElement(By.xpath("//label[@for='third-party-checkbox']")).click();


        WebElement btnRegistro  = driver.findElement(By.xpath("//button[@type='submit']"));

        js.executeScript("arguments[0].scrollIntoView();", btnRegistro);

        btnRegistro.click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Confirma que no eres un robot.')]")).getText(),"Confirma que no eres un robot.");

    }
    */
/*
    @Test
    public void CP002_Registro_Fallido_Captcha_en_blanco() {

        By localizadorBtnRegistrase = By.xpath("//button[contains(text(),'Registrarte')]");

        WebElement btnRegistrarse = driver.findElement(localizadorBtnRegistrase);

        btnRegistrarse.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email"))).sendKeys("domingo.saavedra@tsoftglobal.com");

        driver.findElement(By.name("confirm")).sendKeys("domingo.saedra@tsoftglobal.com");

        driver.findElement(By.name("password")).sendKeys("123454321");

        driver.findElement(By.name("displayname")).sendKeys("Pobre Domingo :D");

        driver.findElement(By.id("day")).sendKeys("28");

        Select cmbMes = new Select(driver.findElement(By.id("month")));

        cmbMes.selectByValue("02");


        driver.findElement(By.name("year")).sendKeys("1991");

        WebElement optionMale = driver.findElement(By.xpath("//label[@for='gender_option_male']"));

        js.executeScript("arguments[0].scrollIntoView();", optionMale);


        optionMale.click();

        driver.findElement(By.xpath("//label[@for='marketing-opt-checkbox']")).click();


        driver.findElement(By.xpath("//label[@for='third-party-checkbox']")).click();

        WebElement btnRegistro  = driver.findElement(By.xpath("//button[@type='submit']"));

        js.executeScript("arguments[0].scrollIntoView();", btnRegistro);

        btnRegistro.click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Las direcciones de correo')]")).getText(),"Las direcciones de correo electrónico no coinciden.");
    }
    */
    @Test
    public void CP003_Iniciar_Sesion(){
        By iniciar = By.xpath("//button[@data-testid='login-button']");
        WebElement btnIniciar = driver.findElement( iniciar);
        btnIniciar.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath ("//button[@data-testid='google-login']"))).click();
        Assert.assertEquals(driver.getTitle(),"Inicia sesión: Cuentas de Google");

    }

@Test
public void CP003_Iniciar_Sesion_Facebook(){

   By iniciarBT = By.xpath("//button[@data-testid='login-button']");
   WebElement btnIniciarFace = driver.findElement(iniciarBT);
   btnIniciarFace.click();

   wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-testid='facebook-login']"))).click();

    driver.findElement(By.xpath("//input[@id='email']")).sendKeys("jesica.rodriguez@tsoftglobal.com");
    driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123454876");
    driver.findElement(By.xpath("//*[@id=\"loginbutton\"]")).click();
    By alertaIniciar = By.xpath("//*[@id=\"globalContainer\"]/div[3]/div/div/div");
    wait.until(ExpectedConditions.presenceOfElementLocated(alertaIniciar));
    WebElement alerta = driver.findElement(alertaIniciar);
    Assert.assertEquals(alerta.getText(), "El correo electrónico que has introducido no está conectado a una cuenta. Encuentra tu cuenta e inicia sesión.");
}
@Test
public void CP004_Iniciar_Sesion_Teléfono(){
By iniciarNum = By.xpath("//button[@data-testid='login-button'] ");
WebElement btnInicNum = driver.findElement(iniciarNum);
btnInicNum.click();

wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-testid='phone-login']"))).click();
    driver.findElement(By.xpath("//input[@id='phonelogin-phonenumber']")).sendKeys("3804556677");
}
@Test
public void CP001_Buscar_Musica() throws InterruptedException {
    By botonBuscar = By.xpath("//*[@id=\"main\"]/div/div[2]/nav/div[1]/ul/li[2]/a/span");
    wait.until(ExpectedConditions.presenceOfElementLocated(botonBuscar));
    WebElement btnBuscar = driver.findElement(botonBuscar);
    btnBuscar.click();

    Thread.sleep(3000);
    By buscar = By.xpath("//input[@placeholder='¿Qué te apetece escuchar?']");
    driver.findElement(buscar).sendKeys("Pop");

    By genero = By.xpath("//*[@id=\"searchPage\"]/div/div/section[6]/div[2]/div[4]/div/div[2]/a/div");
    wait.until(ExpectedConditions.presenceOfElementLocated(genero));
    WebElement mixGenero = driver.findElement(genero);
    Assert.assertEquals(mixGenero.getText(),"Mix Pop");
}


    @Test
    public void cp001_btnIniciarSesionFallido() throws InterruptedException {


        By localizadorBtnIniciarSesion = By.xpath("//button[@data-testid='login-button']");
        WebElement btnIniciarSesion = driver.findElement(localizadorBtnIniciarSesion);
        btnIniciarSesion.click();
        Thread.sleep(3000);
        By localiConApple = By.xpath("//button[@data-testid='apple-login']");
        WebElement btnlogdeapple = driver.findElement(localiConApple);
        btnlogdeapple.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='account_name_text_field']")).sendKeys("jesica.rodriguez@tsoftglobal.com");
        Thread.sleep(3000);
        By localiSignIn = By.xpath("//button[@id='sign-in']");
        WebElement btnsignin = driver.findElement(localiSignIn);
        btnsignin.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='password_text_field']")).sendKeys("12345555");
        Thread.sleep(3000);
        By localiContraseña = By.xpath("//button[@id='sign-in']");
        WebElement btnconfirmarcontraseña = driver.findElement(localiContraseña);
        btnsignin.click();
        Thread.sleep(4000);
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='errMsg']")).getText(),"Contraseña o ID de Apple incorrectos.");
        Thread.sleep(5000);
    }
}
