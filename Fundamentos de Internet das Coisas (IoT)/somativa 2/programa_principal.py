import time
import dht
from machine import Pin
import urequests as requests
from wifi_lib import conectaWifi

ssid = "Diogo Varaschin"
senha = "athletico2402"
conectaWifi(ssid, senha)

sensor = dht.DHT11(Pin(4))
rele = Pin(2, Pin.out)

THINGSPEAK_API_KEY = "YAEO9QYTWAYR1J32"
THINGSPEAK_URL = "https://api.thingspeak.com/update?api_key=YAEO9QYTWAYR1J32&field1=0"

while True:
    try:
        sensor.measure()
        temperatura = sensor.temperature()
        umidade = sensor.humidity()
        print("temperatura: ", temperatura, " umidade: ", umidade, "%")
        
        if temperatura > 31 or umidade > 70:
            rele.value(1)
        else:
            rele.value(0)
            
        response = requests.get(f"{THINGSPEAK_URL}?api_key={THINGSPEAK_API_KEY}&field1={temperatura}&field2={umidade}")
        print("enviado para thingspeak, status: ", response.status_code)
        response.close()
        
        time.sleep(15)
    except Exception as e:
        print("erro: ", e)
        time.sleep(5)