import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import * as jwt_decode from 'jwt-decode';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  username: string;

  constructor(private http: HttpClient, private router: Router) {
  }

  login(username: string, password: string) {
    return this.http.post<any>('/api/auth', {username, password})
    .subscribe(authResponse => {
      const decodedJwt = jwt_decode(authResponse.token);
      localStorage.setItem('token', authResponse.token);
      this.username = decodedJwt.sub;
      this.router.navigate(['/chat']);
    });
  }

  isLoggedIn() {
    return localStorage.getItem('token') !== null;
  }
}
