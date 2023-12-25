import 'dart:async';
import 'dart:convert';
import 'package:http/http.dart' as http;

class Service {
  Future<http.Response> saveUser(
    String firstname,
    String lastname,
    String email,
    String password,
    String phone_number,
    String city,
    String state,
  ) async {
    var uri = Uri.parse("http://localhost:8080/register");

    Map<String, String> headers = {"Content-Type": "application/json"};

    Map data = {
      'firstname': '$firstname',
      'lastname': '$lastname',
      'email': '$email',
      'password': '$password',
      'phone_number': '$phone_number',
      'city': '$city',
      'state': '$state',
    };

    var body = json.encode(data);
    var response = await http.post(uri, headers: headers, body: body);

    print("${response.body}");

    return response;
  }
}
