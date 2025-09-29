import network
import time

def conectaWifi(ssid, senha):
    wlan = network.WLAN(network.STA_IF)
    wlan.active(True)
    if not wlan.isconnected():
        print("conectando a rede wifi, aguarde...")
        wlan.connect(ssid, senha)
        while not wlan.isconnected():
            time.sleep(1)
    print("conectado! ip: ", wlan.ifconfig()[0])
    return wlan