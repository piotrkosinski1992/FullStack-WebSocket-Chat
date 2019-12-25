import {Component, OnInit} from '@angular/core';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.scss']
})
export class ChatComponent implements OnInit {

  private stompClient;

  messages: string[] = [];

  constructor() {
  }

  ngOnInit() {
    this.initializeWebSocketConnection();
  }

  initializeWebSocketConnection() {
    const ws = new SockJS('http://localhost:8080/socket');
    this.stompClient = Stomp.over(ws);
    const that = this;
    this.stompClient.connect({}, function (frame) {
      that.openGlobalSocket();
    });
  }

  openGlobalSocket() {
    this.stompClient.subscribe('/chat', (message) => {
      this.handleResult(message);
    });
  }

  handleResult(message) {
    if (message.body) {
      this.messages.push(message.body);
    }
  }

  sendMessage(message) {
    this.stompClient.send('/app/send/message', {}, message);
  }
}
