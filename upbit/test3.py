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

def get_ma10(ticker):
    df = pyupbit.get_ohlcv(ticker, interval="minute1", count=10)
    ma10 = df['close'].rolling(10).mean().iloc[-1]
    return ma10

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
        current_price = get_current_price("KRW-ETH")
        balance = get_balance("ETH")
        line = pyupbit.get_ohlcv("KRW-ETH", interval="minute1",count = 10)
        if line['open'][0] < line['close'][0]: # up
            check_9 = 1
        else: # down
            check_9 = 0

        if line['open'][1] < line['close'][1]: # up
            check_8 = 1
        else: # down
            check_8 = 0

        if line['open'][2] < line['close'][2]: # up
            check_7 = 1
        else: # down
            check_7 = 0
        
        if line['open'][3] < line['close'][3]: # up
            check_6 = 1
        else: # down
            check_6 = 0
        
        if line['open'][4] < line['close'][4]: # up
            check_5 = 1
        else: # down
            check_5 = 0
        
        if line['open'][5] < line['close'][5]: # up
            check_4 = 1
        else: # down
            check_4 = 0
        
        if line['open'][6] < line['close'][6]: # up
            check_3 = 1
        else: # down
            check_3 = 0

        if line['open'][7] < line['close'][7]: # up
            check_2 = 1
        else: # down
            check_2 = 0

        if line['open'][8] < line['close'][8]: # up
            check_1 = 1
        else: # down
            check_1 = 0

        if line['open'][9] < line['close'][9]: # up
            check_0 = 1
        else: # down
            check_0 = 0

        
        ma10 = get_ma10('KRW-ETH')
        print(ma10)
        print(balance)
        print(current_price)
        print(balance*current_price*0.9995)

        time.sleep(1)
    except Exception as e:
        print(e)
        time.sleep(1)
