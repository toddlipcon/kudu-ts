package org.kududb.ts.core;

import java.util.ArrayList;
import java.util.List;

import org.apache.kudu.test.KuduTestHarness;
import org.apache.kudu.client.HostAndPort;

import org.junit.Rule;

public class BaseTest {
  @Rule
  public KuduTestHarness harness = new KuduTestHarness();

  public List<String> getMasterAddresses() {
    List<String> masterAddresses = new ArrayList<>();
    for (HostAndPort hp : harness.getMasterServers()) {
      masterAddresses.add(hp.toString());
    }
    return masterAddresses;
  }

  public KuduTS createKuduTs(String testName) throws Exception {
    return KuduTS.openOrCreate(getMasterAddresses(),
                               testName,
                               CreateOptions.defaults());
  }
}
