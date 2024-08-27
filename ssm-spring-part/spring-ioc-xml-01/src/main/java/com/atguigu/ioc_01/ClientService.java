package com.atguigu.ioc_01;

public class ClientService {
    private static ClientService clientService = new ClientService();

    private ClientService() {
    }

    private static ClientService createInstance() {
        return clientService;
    }
}
