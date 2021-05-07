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
                print("is not None")
                return float(b['balance'])
            else:
                print("is None")
                return 0

def get_current_price(ticker):
    return pyupbit.get_orderbook(tickers=ticker)[0]["orderbook_units"][0]["ask_price"]

upbit = pyupbit.Upbit(access, secret)
print("autotrade start")

while True:
    try:
        now = datetime.datetime.now()
        print(now)
        print(pyupbit.get_ohlcv("KRW-BTC", interval="minute1",count = 10))
        current_price = get_current_price("KRW-ETH")
        balance = get_balance("KRW-ETH")
        print(current_price)
        time.sleep(1)
    except Exception as e:
        print(e)
        time.sleep(1)
