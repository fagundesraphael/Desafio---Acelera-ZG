import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        String nome = "FulanoDeTal"; // Seu nome completo sem espaços
        String email = "fulanodetal@gmail.com"; // Seu e-mail
        String cpf = "111.222.333-44"; // Seu cpf

        String url = "https://userhashcodeserver.uk.r.appspot.com/hashCodeServer?nome=" + nome + "&email=" + email + "&cpf=" + cpf;
        httpPost(url);
    }

    private static void httpPost(String url) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // Send post request
            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());

            out.flush();
            out.close();

            // Get Response
            int responseCode = con.getResponseCode();

            System.out.println("\nSending 'POST' request to URL : " + url);

            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            System.out.println(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
