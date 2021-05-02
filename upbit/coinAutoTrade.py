import time
import pyupbit
import datetime

access = ""
secret = ""

def get_target_price(ticker, k):
    df = pyupbit.get_ohlcv(ticker, interval="day", count=2)
    target_price = df.iloc[0]['close'] + (df.iloc[0]['high'] - df.iloc[0]['low']) * k
    return target_price

def get_start_time(ticker):
    df = pyupbit.get_ohlcv(ticker, interval="day", count=1)
    start_time = df.index[0]
    return start_time

def get_ma15(ticker):
    df = pyupbit.get_ohlcv(ticker, interval="day", count=15)
    ma15 = df['close'].rolling(15).mean().iloc[-1]
    return ma15

def get_balance(ticker):
    balances = upbit.get_balances()
    for b in balances:
        if b['currency'] == ticker:
            if b['balance'] is not None:
                return float(b['balance'])
            else:
                return 0

def get_current_price(ticker):
    return pyupbit.get_orderbook(tickers=ticker)[0]["orderbook_units"][0]["ask_price"]

upbit = pyupbit.Upbit(access, secret)
print("autotrade start")

while True:
    try:
        now = datetime.datetime.now()
        start_time = get_start_time("KRW-ETH")
        end_time = start_time + datetime.timedelta(days=1)
        if type(upbit.get_avg_buy_price("ETH")) is None :
            avg_price = 0
        else :
            avg_price = upbit.get_avg_buy_price("ETH")
        

        if start_time < now < end_time - datetime.timedelta(seconds=10):
            target_price = get_target_price("KRW-ETH", 0.35)
            ma15 = get_ma15("KRW-ETH")
            current_price = get_current_price("KRW-ETH")

            if target_price < current_price and ma15 < current_price:
                krw = get_balance("KRW")
                if krw > 5000:
                    upbit.buy_market_order("KRW-ETH", krw*0.9995)
            
            if avg_price * 1.1 < current_price and avg_price != 0:
                btc = get_balance("ETH")
                if btc > 0.0015:
                    upbit.sell_market_order("KRW-ETH",btc*0.9995)
                    sleep(180)
            elif avg_price * 0.95 > current_price and avg_price != 0:
                btc = get_balance("ETH")
                if btc > 0.0015:
                    upbit.sell_market_order("KRW-ETH",btc*0.9995)
                    sleep(600)
            
        else:
            btc = get_balance("ETH")
            if btc > 0.0015:
                upbit.sell_market_order("KRW-ETH", btc*0.9995)
        
        print(datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S'))
        print("avg_buy_price : "+(str)(avg_price))
        print("avg * 1.1 : "+(str)(avg_price*1.1))
        print("avg * 0.95 : "+(str)(avg_price*0.95))
        print("target_price : " + (str)(target_price))
        print("ma15 : " + (str)(ma15))
        print("current_price : " + (str)(current_price))
        print("-----------------")
        time.sleep(1)

    except Exception as e:
        print(e)
        time.sleep(1)
